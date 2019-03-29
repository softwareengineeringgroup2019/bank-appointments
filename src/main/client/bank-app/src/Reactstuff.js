import {
    faBriefcase,
    faCar, faChartBar,
    faCreditCard,
    faGraduationCap,
    faHome, faMoneyBillWave,
    faPiggyBank,
    faWallet
} from "@fortawesome/free-solid-svg-icons/index";

<div style={{marginTop: "20px", marginBottom: "20px", backgroundColor:"#006948"}}>

    <h1 style={{ maxWidth:"100%", height:"auto", width:"auto/9", paddingBottom: "20px", marginBottom:"20px", backgroundColor: "white",
        display: "flex", justifyContent: "center"}} > <img src="commerce-bank-logo.png"/>
    </h1>
    <h2 style={{maxWidth: "100%", height:"auto", width:"auto", fontSize: "20px", paddingBottom: "20px", marginBottom: "20px", marginTop: "20px", marginLeft: "50px", marginRight: "50px",}}>
        <Row>
            <Col sm={4} xs >


                <IconButton icon = {faCreditCard}/>Credit Card

            </Col>
            <Col sm={4} xs>

                <FontAwesomeIcon size='4x' color="white" onClick={this.handleClick} icon={faMoneyBillWave} />
                Checking
            </Col>
            <Col sm={4} xs>
                <FontAwesomeIcon size='4x' color="white" onClick={this.handleClick} icon={faCar} />
                Auto Loan
            </Col>
        </Row>

        <Row>
            <Col sm={4} xs>
                <div>
                    <FontAwesomeIcon size='4x' color="white" onClick={this.handleClick} icon={faGraduationCap} />
                    Student Loans
                </div>
            </Col>
            <Col sm={4} xs>
                <FontAwesomeIcon size='4x' color="white" onClick={this.handleClick} icon={faChartBar} />
                Home Equity
            </Col>
            <Col sm={4} xs>
                <FontAwesomeIcon size='4x' color="white" onClick={this.handleClick} icon={faHome} />
                Mortgage
            </Col>

        </Row>

        <Row>
            <Col sm={4} xs>
                <FontAwesomeIcon size='4x' color="white" onClick={this.handleClick} icon={faPiggyBank} />
                Savings
            </Col>
            <Col sm={4} xs>
                <FontAwesomeIcon size='4x' color="white" onClick={this.handleClick} icon={faBriefcase} />
                <h5>Investment Accounts</h5>
            </Col>
            <Col sm={4} xs>
                <FontAwesomeIcon size='4x' color="white" onClick={this.handleClick} icon={faWallet} />
                Student Banking
            </Col>
        </Row>
    </h2>


</div>
